'use strict';
module.exports = (sequelize, DataTypes) => {
  const cal = sequelize.define('cal', {
    title: DataTypes.STRING,
    contents: DataTypes.STRING,
    from: DataTypes.DATE,
    to: DataTypes.DATE,
    from_time: DataTypes.TIME,
    to_time: DataTypes.TIME
  }, {});
  cal.associate = function(models) {
    // associations can be defined here
  };
  return cal;
};