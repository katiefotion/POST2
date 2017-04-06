<?php
    if(!isset($currentPage)){
        $currentPage = "";
    }
    $links = array(
        array('name'=>'Home','uri' => ''),
        array('name'=>'Buy','uri' => 'prototype'),
        array('name'=>'About','uri' => 'about'),
    );
?>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a style="width: 60px;" class="navbar-left" href="<?= site_url(); ?>">
                <img src="<?= base_url('assets/img/gatorsell_sm.png'); ?>" style="max-height: 60px;" class="img-responsive">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <?php foreach ($links as $link){
                    $li = $link['name'] == $currentPage ? '<li class="active">' : '<li>';
                    $url = site_url($link['uri']);
                    echo "$li<a href='$url'>{$link['name']}</a></li>\n";
                }
                ?>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>