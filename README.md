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

# Whats not working?
- I'm currently stuck on updating only unmodified fields in database after downloading new JSON from API. I just need more time for this and I will try again next week.
