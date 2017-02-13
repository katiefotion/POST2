####################
Install Instructions
####################

1. Log into your account
2. Move into your public_html directory

   cd public_html

3. clone the git repo. (Do not miss the period at the end of the statement)

   git clone https://github.com/zebraone100/team10.git .

4. Move into the config directory

   cd application/config

5. Copy two config files.  The new files are not tracked in the repo.  They have
   user specific information in them that can't change as we push and pull versions

   cp CopyMe-config.php config.php

   cp CopyMe-database.php database.php

6. Edit config.php with your favorite shell text browser. i.e. nano, pico, vi
   and then edit the entry : 

   $config['base_url'] = '';

   to 

   $config['base_url'] = 'http://sfsuse.com/~username/';

   where username is your username that you logged on with

7. Test it in a web browser. You should get a hello world message

###################
Working with an IDE
###################

The most productive way to build large projects is to use an IDE.  The IDE can give you code completion tips,
automate pushing and pulling to the repo, and make navigating much simpler.

And far better is to run it on your own machine.  For M0, you need to have a running version on your shell account,
however, for real development, running a local copy will prove to be much simpler.

*************
windows setup
*************

You don't need a web server as php has a built-in test server.

1.  Install php 7.0 by downloading the zip file from: http://windows.php.net/download  Any version is fine as long as
    it will run on your machine

2.  Extract it into c:/php
3.  rename php.ini-development  to  php.ini

4.  if you wish to use intellij instead of netbeans, install git for windows: https://git-for-windows.github.io/

5.  Install netbeans or intellij - ensure PHP language plug-in/support is installed

6.  clone the repo:  https://netbeans.org/kb/docs/ide/git.html#clone or https://www.jetbrains.com/help/idea/2016.3/cloning-a-repository-from-github.html

7.  make copies of the CopyMe files and rename the copies to config.php and database.php (DO NOT RENAME OR DELETE THE ORIGINALS)

8.  edit config.php :  $config['base_url'] = 'http://localhost:8000/';  (8000 is the port you choose for the test server.  It can be whatever you want it to be)

9.  For netbeans, select tools/options/php and set php 5 interpreter to : c:/php/php.exe

10. For netbeans, select file/project properties/run configuration  run as: PHP built-in webserver    hostname: localhost  port: 8000

11. For intellij :  https://www.jetbrains.com/help/idea/2016.3/php-built-in-web-server.html

Take the time to figure out how to push, pull, commit, etc with your IDE

Remember: Google is your friend...

