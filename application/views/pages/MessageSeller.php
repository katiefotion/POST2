<div class="container">
    <div class="row">
        <div class="text-center">
            <?php
                echo "<h1>GatorSell Messaging System</h1>";
                echo "<h5>Message the seller about purchasing the item or about questions pertaining to the product</h5>";
            ?>
             
        </div>
    </div>
</div>


<div class='container'>
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <?php
                //should have data field of item description/name in subject line auto filled
                echo "<h3>SUBJECT : </h3>";
                echo "<textarea name=\"subject\" rows=\"1\" cols=\"90\"></textarea>";
            ?> 
        </div>
    </div>

    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <?php
                echo "<h3>MESSAGE :</h3>";
                echo "<textarea name=\"message\" rows=\"5\" cols=\"90\"></textarea>";
            ?>
        </div>
    </div>
</div>


