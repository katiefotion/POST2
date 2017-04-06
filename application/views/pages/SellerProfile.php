<div class="container">
    <div class="row">
        <?php
            echo "<h1 class=\"text-center\">Seller Profile</h1>";
        ?>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <?php
                $path = site_url("/Add_New_Post");
                echo "<a href='$path' style=\"font-size: large\" "
            . "class=\"btn btn-default btn-block\" role=\"button\">Add New Post</a>";
                
            ?>
            
        </div>
    
        <div class="col-sm-6">
            <?php
                $path = site_url("/Add_New_Post");
                echo "<a href='$path' style=\"font-size: large\" "
            . "class=\"btn btn-default btn-block\" role=\"button\">Check Messages</a>";
                
            ?>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">    
            <?php
                echo "<h3>Current Posts: </h3>";
            ?>
    </div>
</div>
