# Update 14.04.2021
- added DTO layer
- added Swagger-ui (http://localhost:8080/swagger-ui.html)

# Update 29.03.2021
- now app compares downloaded posts from JSON with posts saved in database and dont overwrite modified or deleted items
- added exceptions handling for posts with wrong or not existing ID (for delete or update)
- now app updates every 24 hours with cron rather than fixedrate
- also added some tests for rest controller, JPA and service layer

# TODO (things I want to improve)
- use maps for duplicate checking after update (now i have loop in loop and if ind if, it works, but I'm not so proud of it ;)
- do something with two methods downloadPostsAtStart() and downloadPostAndCompare(), which in some part do the same thing
- i also want to change API to something dynamic (now downloaded posts are always the same), so now downloadPostAndCompare() does almost nothing. Its just overwriting same content to database. But these are requirements of the recruiting task.

# Whats working and how to use it?
- app downloads JSON API every 24 hours
- app saves all posts to database (H2)
- it also download and save posts on demand by using REST GET on http://localhost:8080/posts
- you can search by title when using REST POST on http://localhost:8080/posts). Just type existing word from title in database (for example "facere") and paste it in Postman as Body > Raw. It should return 3 posts with that word.
- you can delete any post using DELETE method on endpoint: http://localhost:8080/posts/1, where "1" is id number.
- there is also ability to update any object (title and body) using method PUT on http://localhost:8080/posts. You just need to paste JSON, for example:     {
        "id": 2,
        "title": "modified",
        "body": "modified"
    }
- userId is written to database, but hidden in REST API.

~~# Whats not working?~~
~~- I'm currently stuck on updating only unmodified fields in database after downloading new JSON from API. I just need more time for this and I will try again next week.~~
~~- I also forgot about tests, will do it also next week~~
