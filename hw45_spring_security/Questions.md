### 2.  What is HTTP Session?
HTTP sessions is an industry standard feature that allows Web servers to maintain user identity and to store user-specific data during multiple request/response interactions between a client application and a Web application.

### 3.  What is Cookie?
A cookie is information that a website puts on a user's computer. Cookies store limited information from a web browser session on a given website that can then be retrieved in the future. They are also sometimes referred to as browser cookies, web cookies or internet cookies.

### 4.  What is the difference between Session and Cookie?
Cookies are client-side files that are stored on a local computer and contain user information. Sessions are server-side files that store user information. Cookies expire after the user specified lifetime. The session ends when the user closes the browser or logs out of the program.

### 5.  How do we use session and cookie to keep user information across the application?
When you visit an online shop and add items to your shopping cart, the session cookie remembers your selection so your shopping cart will have the items you selected when you are ready to checkout. Without session cookies, the checkout page will not remember your selection and your shopping cart will be empty.

### 6.  What is the spring security filter?
Spring Security maintains a filter chain internally where each of the filters has a particular responsibility and filters are added or removed from the configuration depending on which services are required. The ordering of the filters is important as there are dependencies between them

### 7. Do you use any Encoder to encode Password?

### 8.  What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)
1.The UserDetailsService interface is used to retrieve user-related data. It has one method named loadUserByUsername() which can be overridden to customize the process of finding the user. It is used by the DaoAuthenticationProvider to load details about the user during authentication.
2.Authentication providers are responsible to perform a specific authentication. Spring security provides several AuthenticationProvider . Remember these AuthenticationProviders can't execute directly, but spring security uses ProviderManager class which delegates to a list of configured authentication providers.
3.AuthenticationManager is a static class that manages the authentication modules that an application uses. When a request is made to protected resources, the AuthenticationManager calls the Authenticate method to get an Authorization instance to use in subsequent requests
4.An authentication filter is a component that authenticates an HTTP request. Web API 2 and MVC 5 both support authentication filters, but they differ slightly, mostly in the naming conventions for the filter interface. This topic describes Web API authentication filters.

### 9.  What is the disadvantage of Session? how to overcome the disadvantage?
Disadvantages: 1. Performance overhead in case of large number of user, because of session data stored in server memory. 2. Overhead involved in serializing and De-Serializing session data because in case of StateServer and SQLServer session mode we need to serialize the object before store

### 10. What is JWT?
A JWT is a mechanism to verify the owner of some JSON data. It's an encoded, URL-safe string that can contain an unlimited amount of data (unlike a cookie) and is cryptographically signed. When a server receives a JWT, it can guarantee the data it contains can be trusted because it's signed by the source.

### 11. describe how do JWT work(slides 里有图， 26页)
JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed.

### 12. how to get value from application.properties?
Another very simple way to read application properties is to use @Value annotation. Simply annotation the class field with @Value annotation providing the name of the property you want to read from application. properties file and class field variable will be assigned that value.

### 13. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
The configure(final HttpSecurity http) method overrides the default HttpBuilder configuration. Because it's empty, it leaves the application without authorization or authentication

### 14. What is Spring security authentication and authorization?
Authentication is the process of knowing and identifying the user that wants to access. ADVERTISEMENT. ADVERTISEMENT. Authorization is the process to allow authority to perform actions in the application. We can apply authorization to authorize web request, methods and access to individual domain.