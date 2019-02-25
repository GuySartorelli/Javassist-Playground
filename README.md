# Javassist Playground

This is just a quick java project for me to check out the [Javassist](http://www.javassist.org/) library.  
The library, at least for my purposes, is useful for editing a java class at runtime. In this small project 
I am seeing how to override a method in and add a field to a subclass. This is for my [UnityView](https://github.com/GuySartorelli/unity_view) project.  
In that project, in order to limit the amount of boilerplate code a dev needs to add (especially in their native code, as Flutter is intended to abstract from native code) 
I aim to alter the MainActivity with a field for the UnityPlayer object as well as overriding some Activity methods as appropriate to allow Unity to react to certain 
events on the device (e.g. pausing when the app loses focus).  
  
It is important to note that this will only work if Flutter does not load the MainActivity class before the code that edits it is executed. I am hoping that executing the code in  
a static block will help to ensure this, but it could well be that the MainActivity will be loaded and possible even instantiated before the plugin code has been executed.  
More testing and research will need to be conducted to know which is the case. I will also need a way to find the app's package name. I was going to get it through the Android context 
however this would require the MainActivity class to be loaded to the JVM well before the pertinent code is executed, which will cause an exception as noted above. I am hoping there 
is a fairly straightforward way to access the package name from either gradle or yaml files.