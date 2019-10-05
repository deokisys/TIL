'use strict';
module.exports = (sequelize, DataTypes) => {
  const cons_cal = sequelize.define('cons_cal', {
    title: DataTypes.STRING,
    contents: DataTypes.STRING,
    from: DataTypes.DATE,
    to: DataTypes.DATE,
    from_time: DataTypes.TIME,
    to_time: DataTypes.TIME
  }, {});
  cons_cal.associate = function(models) {
    // associations can be defined here
  };
  return cons_cal;
};