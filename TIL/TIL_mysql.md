### 설치
- brew로 설치
```
brew install mysql@5.7
```
- 환경 설정
```
//zsh기준
echo 'export PATH="/usr/local/opt/mysql@5.7/bin:$PATH"' >> ~/.zshrc
```
- 시작
```
brew services start mysql@5.7
```
- 비밀번호 설정
```
mysqladmin -u root password '<password>'
```
- 제거
```
brew remove mysql@5.7
```
- 참고
    - https://junho85.pe.kr/1018