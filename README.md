# JFXHibernate
This is a test app where I tried to apply the **MVC** model we would normally use in a web app, in a javaFX desktop app using hibernate, the main goal of this is to set up a model structure for any project.

Here we have two simple entities: _User_ and _Task_
<p align="center">
  <img src="https://github.com/DevTony101/JFXHibernate/blob/master/model.png" alt="DatabaseModel" />
</p>

Because it is always good to separate the responsibilities in our program, we implement the Multitier architecture:
1. First, we create the entities, a simple POJO to map the entries from the database
2. We create the repositories, a class that is going to talk directly with the database through Hibernate (which is an implementation of JPA). In this particular case, I create a generic interface _DAORepository_ and then implement it for each entity.
3. Then we create the services, a class that acts as a bridge between the controller and the repository
4. Finally, we proceed to create the views and controllers as we know

### TO-DO
- Implement proper validations when creating a new user and/or task
- Extend the functionality of the app to use the rest of the CRUD operations (Currently, we only use create and update)

### Improvements
- It is recommended to create an interface for the services and then create a class to implement the methods, here we create the methods directly in the class
- When creating an information control system, it is useful to have some kind of registry that tells us **when** a certain entry was modified in a table and **who** did it, that process is called _Audit_, thus a great improvement would be to implement _@PrePersist_ and _@PreUpdate_ (JPA entity listeners) to simulate that behaviour
