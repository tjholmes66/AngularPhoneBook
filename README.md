AngularPhoneBook
================

When I first started this project, I had intended this to have a RESTful web-services backend for this PhoneBook.
And on the front-end, I would have a strictly a front-end created with AngularJS.

The whole project, front-end and back-end would have been folded into one WAR file.

However, as of Thursday, May 14th, 2015 at 8:15pm (EST) I changed all that.

All aspects of the back-end have been removed from this project.
There is no need for Spring or Hibernate here.

This is now a strictly front-end web-app with AngularJS.

The RESTful web-services back-end piece has now been transferred to it's own project.

On one case, it's nice to have the whole package together ...
On the other hand, since I plan on doing multiple different front-ends including a mobile piece ...
it then makes sense to do the back-end ONCE and then re-use it for the multiple front-end projects
rather than copying the back-end to all these different pieces.


