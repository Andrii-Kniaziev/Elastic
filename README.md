1) How to implement the validation of incoming requests using the Spring Framework and process only those with a custom header "X-VERSION" containing the version of the mobile client, which is greater than a specified value?

Answer: package com.knzv.khrsn.demo.interceptor.RequestHeaderCheckInterceptor   --->   Registered in package com.knzv.khrsn.demo.config.WebMvcConfig


2) How to implement the periodic execution of a method every day at a specific time using the Spring Framework?

Answer: package com.knzv.khrsn.demo.scheduler.ScheduledTask   ---> To Enable added annotation @EnableScheduling to the main class

3) How would you implement logging for all API methods called by a user, with the subsequent ability to generate reports on user activit

Answer: I created interceptor that will executed after each API call. ---> package com.knzv.khrsn.demo.interceptor.UserRequestLoggingInterceptor
        In this interceptor we save data about each API call to Elasticsearch NoSQL db, after that we are able to fetch data from Kibana.
        Docker compose file for elastic + kibana you can fin in folder "elastic" in the root of the project.
