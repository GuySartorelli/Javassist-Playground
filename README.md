# Javassist Playground

This is just a quick java project for me to check out the [Javassist](http://www.javassist.org/) library.  
The library, at least for my purposes, is useful for editing a java class at runtime. In this small project 
I am seeing how to override a method in and add a field to a subclass. This is for my [UnityView](https://github.com/GuySartorelli/unity_view) project.  
In that project, in order to limit the amount of boilerplate code a dev needs to add (especially in their native code, as Flutter is intended to abstract from native code) 
I aim to alter the MainActivity with a field for the UnityPlayer object as well as overriding some Activity methods as appropriate to allow Unity to react to certain 
events on the device (e.g. pausing when the app loses focus).  
