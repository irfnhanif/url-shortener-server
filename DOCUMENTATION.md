# URL Shortener

## Problem Statement
Design a web application that help shorten the URL which is going to be shared to other people

### Scope
- Include:
    - Generate short URL path
    - URL mapping storage
    - Redirection Logic

- Assumption:
    - User has URL address ready to be shorten
    - User has custom URL or not
    - The system has high availability
    - URLs are publicly accessible
    - Short URLs should be as compact as possible
    - Short URLs have an expiration policy

## Use Cases
1. **URL Shortening**
    - **Actor**: End User
    - **Description**: User submits a long URL to be shortened
    - **Flow**:
      - User enters long URL in the input form
      - System validates the URL
      - System generates a unique short URL
      - System displays the shortened URL to the user

2. **Custom URL Creation**
    - **Actor**: End User
    - **Description**: User creates a custom short URL path
    - **Flow**:
      - User enters long URL and desired custom path
      - System checks availability of custom path
      - System creates mapping if available
      - System notifies user of success or suggests alternatives

3. **URL Redirection**
    - **Actor**: Link Visitor
    - **Description**: Visitor uses a short URL and is redirected to the original URL
    - **Flow**:
      - Visitor clicks or enters short URL
      - System looks up the original URL
      - System redirects visitor to the original URL
      - System records the click event


## Requirement
### Functional Requirements
1. **URL Shortening**
    - System must validate input URLs for proper format
    - System must generate unique short codes for URLs
    - System must store mappings between short codes and original URLs
    - Generated URLs must be easy to copy and share

2. **Custom URL Paths**
    - System must allow users to specify custom path segments
    - System must validate custom paths for uniqueness and allowed characters
    - System must provide feedback when a requested custom path is unavailable

3. **Redirection**
    - System must redirect visitors from short URLs to original URLs
    - Redirection must happen with minimal latency
    - System must handle cases where URLs don't exist with appropriate error messages


### Non-Functional Requirements
1. **Performance**
    - URL redirection should complete in under 100ms
    - The system should handle at least 1000 redirects per second

2. **Availability**
    - Service should have 99.9% uptime
    - System should be fault-tolerant with no single point of failure

3. **Security**
    - System must validate and sanitize all user inputs
    - System must prevent generation of malicious short URLs

4. **Data Retention**
    - URLs should expire after a configurable time period
    - URL mapping data should be backed up regularly

