####################
Install Instructions
####################

1.  Log into your account
2.  Move into your public_html directory

cd public_html

3. clone the git repo. (Do not miss the period at the end of the statement)

git clone https://github.com/zebraone100/team10.git .

4. Move into the config directory

cd application/config

5. copy two config files.  The new files are not tracked in the repo.  The have
user specific information in them that can't change as we push and pull versions

cp CopyMe-config.php config.php

cp CopyMe-database.php database.php

6. edit config.php with your favorite shell text browser. i.e. nano, pico, vi
and then edit the entry : 

$config['base_url'] = '';

to 

$config['base_url'] = 'http://sfsuse.com/~username/';

where username is your username that you logged on with

7.  test it in a web browser. You should get a hello world message
