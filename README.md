# NestedMotionLayout
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
<br>

## An easy workaround to use MotionLayout with nested children in XML
<br><br>
"MotionLayout works only with its direct children. It does not support nested layout hierarchies or activity transitions."

Welp, a beautiful app usually has complex XML hierarchies, so keeping all the UI things as direct child is kinda impossible, so with few easy lines of code I made it works as you can see:
<br>

<img width="500" height="500" src="https://github.com/miguelhincapie/NestedMotionLayout/blob/master/docs/images/NestedMotionLayout.gif">
<br><br>

## This is how Activity XML hierarchy looks like

<br>
<img width="644" height="849" src="https://github.com/miguelhincapie/NestedMotionLayout/blob/master/docs/images/XML%20tree.png">

## The magic

As you can see in above XML, there are three scenes: activity_main_scene, header_container_scene, child_header_container_scene. Each one will take care about its direct children and the only missing thing is synch them up:

1. Implement MotionLayout.TransitionListener in your Activity, Fragment or independent class.
2. Create the scenes you need (in the example I have 3)
3. set up the transaction listener for each one (call this fun in onCreate, onViewCreated or something like that): 
```
private fun setUpMotionLayoutListener() = with(binding) {
        rootContainer.setTransitionListener(this@MainActivity)
        headerContainer.setTransitionListener(this@MainActivity)
        childHeaderContainer.setTransitionListener(this@MainActivity)
    }
```
4. synchronise them using following code:
```
private fun updateNestedMotionLayout(motionLayout: MotionLayout?) = motionLayout?.let {
        with(binding) {
            if (it.id == rootContainer.id) {
                headerContainer.progress = it.progress
                childHeaderContainer.progress = it.progress
            }
        }
    }
```
And that's all!


## About me

### Stackoverflow Developer Story
<a href="http://stackoverflow.com/users/1332549/miguelhincapiec">
<img src="http://stackoverflow.com/users/flair/1332549.png" width="208" height="58" alt="profile for MiguelHincapieC at Stack Overflow, Q&amp;A for professional and enthusiast programmers" title="profile for MiguelHincapieC at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
</a>

<br><br>
<a class="LI-simple-link" href="https://www.linkedin.com/in/miguelhincapie">
<img width="208" height="58" src="https://content.linkedin.com/content/dam/me/business/en-us/amp/brand-site/v2/bg/LI-Logo.svg.original.svg">
</a>
