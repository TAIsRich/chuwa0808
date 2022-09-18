# Homework 14

1. List all of the annotations you learned from class and homework to annotaitons.md

   - See annotations.md

2. What is HTTP Session?

   - HTTP sessions is an industry standard feature that allows Web servers to maintain user identity and to store user-specific data during multiple request/response interactions between a client application and a Web application.

3. What is Cookie?

   - **HTTP cookies** (also called **web cookies**, **Internet cookies**, **browser cookies**, or simply **cookies**) are small blocks of data created by a web server while a user is browsing a website and placed on the user's computer or other device by the user's web browser. Cookies are placed on the device used to access a website, and more than one cookie may be placed on a user's device during a session.

4. What is the difference between Session and Cookie?

   - | Cookie                                                       | Session                                                      |
     | ------------------------------------------------------------ | ------------------------------------------------------------ |
     | Cookies are client-side files on a local computer that hold user information. | Sessions are server-side files that contain user data.       |
     | Cookies end on the lifetime set by the user.                 | When the user quits the browser or logs out of the programmed, the session is over. |
     | It can only store a certain amount of info.                  | It can hold an indefinite quantity of data.                  |
     | The browser’s cookies have a maximum capacity of 4 KB.       | We can keep as much data as we like within a session, however there is a maximum memory restriction of 128 MB that a script may consume at one time. |
     | Because cookies are kept on the local computer, we don’t need to run a function to start them. | To begin the session, we must use the session start() method. |
     | Cookies are not secured.                                     | Session are more secured compare than cookies.               |
     | Cookies stored data in text file.                            | Session save data in encrypted form.                         |
     | Cookies stored on a limited data.                            | Session stored a unlimited data.                             |
     | We can set an expiration date to delete the cookie’s data. It will automatically delete the data at that specific time. | In PHP, to destroy or remove the data stored within a session, we can use the session_destroy() function, and to unset a specific variable, we can use the unset() function. |

5. How do we use session and cookie to keep user information across the the application? 

   1. Client sends an HTTP request.
   2. Server check if no session ID create a new session then return a session Id to Client
   3. Client save session ID inforamtion in cookie
   4. Follow Client request will includes the session Id information 
   5. Web will check the session ID and find the Httpsession and find user information.

6. What is the spring security filter?

   - Spring Security maintains a filter chain internally where each of the filters has a particular responsibility and filters are added or removed from the configuration depending on which services are required. The ordering of the filters is important as there are dependencies between them.

7. Do you use any Encoder to encode Password?

   - MD5, SHA, Bcrypt, script(rainbow table)

8. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)

   - UserDetailsService is used by DaoAuthenticationProvider for **retrieving a username, password, and other attributes for authenticating with a username and password**. Spring Security provides in-memory and JDBC implementations of UserDetailsService .
   - Spring Security provides a variety of options for performing authentication. These options follow a simple contract; **an Authentication request is processed by an AuthenticationProvider**, and a fully authenticated object with full credentials is returned.
   - What Is the AuthenticationManager? Simply put, the AuthenticationManager is **the main strategy interface for authentication**. If the principal of the input authentication is valid and verified, AuthenticationManager#authenticate returns an Authentication instance with the authenticated flag set to true.
   - **A Filter that performs authentication of a particular request**. An outline of the logic: A request comes in and if it does not match setRequestMatcher(RequestMatcher) , then this filter does nothing and the FilterChain is continued.

9. What is the disadvantage of Session? how to overcome the disadvantage?

   - Advantage: If you have a variable that needs to be passed around to a lot of web pages, it may simplify things to use a Session variable, rather than passing the variable around through the QueryString. 
   - DisAdvantage: 
     - Session variables and cookies are synonymous. So if a user has set his browser not to accept any cookies, your Session variables won't work for that particular web surfer.
     - Performance overhead in case of large number of user, because of session data stored in server memory.
     - Overhead involved in serializing and De-Serializing session data because in case of StateServer and SQLServer session mode we need to serialize the object before store.
   - Using token.

10. What is JWT?

    - JWT (JSON Web Tokens) are tokens that are generated by a server upon user authentication in a web application and are then sent to the client (normally a browser). As a result, these tokens are sent on every HTTP request, allowing the server to verify or authenticate the user's identity. This method is used for authorizing transactions or requests between client and server. The use of JWT does not intend to hide data, but rather ensure its authenticity. JWTs are signed and encoded, instead of encrypted. A cryptographic algorithm is used to digitally sign JWTs in order to ensure that they cannot be altered after they are issued. Information contained in the token is signed by the server's private key in order to ensure integrity. 

11. decribe how do JWT work(slides 里有图， 26页)

    - Token-based authentication is probably the most common method for authenticating requests to REST API endpoints. It works like this:

      1. A user logs in to an application with a username and password, or otherwise proves her identity.
      2. The server confirms her identity and sends back an access token containing a reference to her identity (e.g. a private key pointing to a unique User instance).
      3. The client then includes this access token with every request to the server.
      4. For protected routes, REST API authentication middleware asserts the presence of a valid access token. The server can further use the identity asserted by the validated token to implement more granular permissions, such as acting on resources belonging to that particular user.

      A JWT’s characteristics make it a great choice for token-based authentication. We want a lightweight package, since it will be included on every single request to our REST API. It also must be tamper-proof, so that the identity claim cannot be altered in transit or spoofed outright.

12. how to get value from application.properties?

    - `@ConfigurationProperties` can be used to map values from `.properties`( `.yml` also supported) to a POJO.
    - **The `@Value` annotation**
    - **The `@PropertySource` annotation**
    - https://stackoverflow.com/questions/30528255/how-to-access-a-value-defined-in-the-application-properties-file-in-spring-boot

13. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

    - A HttpSecurity is similar to Spring Security's XML <http> element in the namespace configuration. It **allows configuring web based security for specific http requests**. By default it will be applied to all requests, but can be restricted using requestMatcher(RequestMatcher) or other similar methods
    - **Allows providing a parent AuthenticationManager that will be tried if this AuthenticationManager was unable to attempt to authenticate the provided Authentication** 

14. What is Spring security authentication and authorization?

    - **Authentication:** This refers to the process of verifying the identity of the user, using the credentials provided when accessing certain restricted resources. Two steps are involved in authenticating a user, namely identification and verification. An example is logging into a website with a username and a password. This is like answering the question Who are you? 
    - **Authorization:** It is the ability to determine a user's authority to perform an action or to view data, assuming they have successfully logged in. This ensures that users can only access the parts of a resource that they are authorized to access. It could be thought of as an answer to the question Can a user do/read this? 

15. Reading, 泛读一下即可，自己觉得是重点的，可以多看两眼。https://www.interviewbit.com/spring-security-interview-questions/#is-security-a-cross-cutting-concern
    a. 1-12
    b. 17 - 30