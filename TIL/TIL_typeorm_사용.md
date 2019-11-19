## typeorm
- docker의 mysql로 올림
- https://github.com/connect-foundation/2019-11 에서 server코드를 확인

### 폴더구조
- models
    - 데이터베이스 테이블을 정의하는곳
        - @PrimaryGeneratedColumn()
            - 키를 정의
            - generated라 선언하여 auto incresemenet도 같이 적용
        - @Column
            - 일반적인 컬럼을 선언
    - 속성
        - string, number, date, boolean등을 사용가능
    - 관계
        - OneToOne, OneToMany, ManyToOne, ManyToMany를 선언가능
    - 예시
        ```
        import { Entity, PrimaryGeneratedColumn, Column, OneToMany, ManyToOne} from 'typeorm';
        import { Images } from './Images';
        import { Users } from './Users2';

        @Entity()
        export class Products {
        @PrimaryGeneratedColumn()
        id: number;

        @Column()
        title: string;


        @OneToMany(type => Images, images => images.id)
        images: Images[];

        @ManyToOne(type => Users, users => users.id)
        user: Users;
        }
        ```
- repositories

    - entity manager와 repository
        - entity manager를 통해 insert, update, create, delete(crud)가 가능
        - repository는 entitymanager와 비슷하지만, concrete entity로 제한된다.

    - repository는 하나의 테이블에서 나오는 로직을 처리

    ```
        import { EntityRepository, Repository, EntityManager } from 'typeorm';
        import { Users } from '../models/Users';
        /** Entity Manager - Constructor Injecction
        *  1. TypeOrm 역시 TypeDI의 Container를 사용한다.(server.ts 참조)
        *  2. 그래서 TypeOrm의 EntityManager는 TypeDI에 등록되있다.
        *  3. 그렇기 때문에, 아래서 @Inject 데코레이터 없이 생성자 주입이 가능하다.
        *  4. TODO: TypeDi와 Container 연결없이, 생성자 Injection이 되는지 확인해보자.
        */

        @EntityRepository()
        export class UserRepository {
        constructor(private readonly em: EntityManager) {}

        public find() {
            return this.em.find(Users);
        }

        public findOne(id: number) {
            return this.em.findOne(Users, id);
        }

        //find 심화
        //select * from auction_log where auction_id=auction_id, is_winning=true
        //위의 내용을 type orm으로 바꾸기
        public findBuyLogs(user_id : number) {
        return this.em.find(Auction_logs,{
            where:{
                user: { id: user_id },
                is_winning:true
            }
        });


        public save(user: Users) {
            return this.em.save(user);
        }
        }

    ```
- services
    - 필요에 따라 여러 repository를 조합하여 처리 하기 위한 처리단계

    ```
        import { Service } from 'typedi';
        import { UserRepository } from '../repositories/UserRepository';
        import { InjectRepository } from 'typeorm-typedi-extensions';
        import { Users } from '../models/Users';

        /** TODO: Transaction을 어떻게 처리해야 좋을까? */
        @Service()
        export class UserService {
        constructor(
            @InjectRepository() private readonly userRepository: UserRepository
        ) {}

        /** GET */
        public find() {
            return this.userRepository.find();
        }

        public findOne(id: number) {
            return this.userRepository.findOne(id);
        }

        /** POST */
        public create(user: Users) {
            return this.userRepository.save(user);
        }

        /** PUT, PATCH */
        public update(id: number, user: Users) {
            /**TODO: 해당 id값으로 Entitiy를 조회해서, 새로운 user 엔티티로 변경 */
        }

        /** DELETE */
        public delete(id: number) {
            /**TODO: 해당 id값으로 Enitity 삭제 */
        }
        }

    ```

- controllers
    - service에서 함수를 사용한다.
    - api폴더에 파일을 생성한다.

    - 예시
    ```
        import {
        JsonController,
        Get,
        Param,
        Post,
        Body,
        Patch,
        Put,
        Delete,
        OnUndefined
        } from 'routing-controllers';

        //service와 모델을 import한다.

        import { UserService } from '../../services/UserService';
        import { Users } from '../../models/Users';

        /** TypeDi Constructor Injection 작동 방식
        * 1. TypeDi의 Container를 routing-controllers가 사용한다.(server.ts 소스 코드 참조)
        * 2. TypeDi가 Controller로 등록된 클래스들을 알고 있다.
        * 3. TypeDi는 @Inject를 통해서 dependency를 주입하는데, 생성자 주입(Constructor Injection)의 경우 @Inject를 생략해도 된다.
        */
        //컨트롤러 설정 부분
        //아래의 의미는 localhost:3000/api/users 로 시작한다는 의미이다.//자신이 만든 api이름을 넣으면 된다.
        @JsonController('/users')
        export class UserController {
        constructor(private readonly userService: UserService) {}

        @Get()
        public find() {
            return this.userService.find();
        }
        //get으로 받는 부분
        //get의 api의 마지막은 param이 아닌경우 에러가 난다. 
        //ex) Get('/feafea/:num')(o) / Get('/feafea')(x) 
        //Get내부에서 조건문을 사용하는 방식을 고려해보자.
        @Get('/:id')
        public findOne(@Param('id') id: string) {
            return this.userService.findOne(parseInt(id));
        }

        @Post()
        public create(@Body() user: Users) {
            //TODO: user을 Users Model에 맞게 class-transformer를 사용해서 처리하자
            return this.userService.create(user);
        }
        //post으로 받는 부분
        //post body로 값을 넘기는 경우 BodyParam 을 이용하자
        // @BodyParam("name") userName: number
        //위의 의미는 body의 name부분을 받아서 userName에 넣는다는 의미이다. 헷갈리지 않도록 하자.
        @Post('/tests')
        public aaabbbb(@BodyParam("name") userName: number) {
            if(userName>10){//이런식으로 내부에 조건문을 활용할수 있다.//쓸지는 모르지만 참고//좋은 방식인지는 모르겠다.
            return [1,1,1];
            }
            return this.logService.findBuyLogs(userName);
        }

        @Put('/:id')
        @Patch('/:id')
        public update(@Param('id') id: string, @Body() user: Users) {
            //TODO: user을 Users Model에 맞게 class-transformer를 사용해서 처리하자
            return this.userService.update(parseInt(id), user);
        }

        @Delete('/:id')
        public delete(@Param('id') id: string) {
            return this.userService.delete(parseInt(id));
        }
        }

    ```
    

