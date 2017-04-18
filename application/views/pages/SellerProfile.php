<?php
    $user = "Samuel";
    $email = "sjackson@gmail.com";
    $phone = "(555) 555-5555"
?>

<div class="container-fluid">
    <div class="row">
        <h1 class="text-center">My Account</h1>
    </div>
    
    <div class="row">
        <div class="col-md-2"></div>
        <div class ="col-md-8 ">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Welcome Back, <?php echo $user?></h3>
                </div>
                <div class="panel-body">
                    <div class="col-sm-8">
                        <label>Email: </label><p><?php echo $email?></p>
                        <label>Phone Number: </label><p><?php echo $phone?></p>
                    </div>
                    <div class="col-sm-4">
                        <h5><a href="<?=  site_url('ViewMessages')?>">View All Messages</a></h5>
                        <h5><a href="<?=  site_url('forgotPwd')?>">Forgot Password?</a></h5>
                    </div>
                    <p></p>  
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
    
    <div class="row">
        <div class="col-md-2"></div>
        <div class ="col-md-8 ">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Current Items Posted</h3>
                </div>
                <div class="panel-body">
                    <div class="col-sm-4">
                        <?php
                            $path = site_url("dbimg/19");
                            echo "<a href=''><img src='$path' class='img-responsive'></a>";
                        ?>
                    </div>
                    <div class="col-sm-4">
                        <?php
                            $path = site_url("dbimg/22");
                            echo "<a href=''><img src='$path' class='img-responsive'></a>";
                        ?>
                    </div>
                    <div class="col-sm-4">
                        <?php
                            $path = site_url("dbimg/27");
                            echo "<a href=''><img src='$path' class='img-responsive'></a>";
                        ?>
                    </div>
                    <p></p>  
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
    
</div>