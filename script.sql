show databases;
drop database LinkSharing;
use LinkSharing;

show tables;

select * from User;
describe User;

update User set password=12345 where user_id=1;

delete from User where user_id=2;


select * from Topic;
describe Topic;


select * from Topic,User where User.user_id=Topic.createdBy_user_id and User.user_id=2;

select * from Topic left join User on User.user_id=Topic.createdBy_user_id and User.user_id=2;



select * from Subscriptions;
describe Subscriptions;



select * from Resource;
describe Resource;
insert into Resource (user_id, dateCreated, description, lastUpdated, topic_topic_id, url, DTYPE)
 values (1, NOW(), " adasdsadasd", NOW(),1 , "ssads", 'resource_link');


select * from ReadingItem;
describe ReadingItem;


select * from ResourceRating;
describe ResourceRating;