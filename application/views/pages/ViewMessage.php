<?php
$item = array('name' => 'TESTNAME', 'description' => 'Descritipiont asdfsadf', 'category_id' => 'Tech', 'price' => '4.99');
$messages = array('sender_id' => 'FROM THIS DUDE', 'receiver_id' => 'TO ME', 'date_sent' => '4/12/17 5:00', 'message' => "hello blah balh bah", 'location_id' => "Quad");
?>
<div class = "container-fluid">
    <div class = "row">
        <div class = "col-md-1">
        </div>
        <div class = "col-md-3">
            <a href="#" class="btn btn-default" role="button">Back</a>
            <label for="picture">Picture:</label>
        </div>
        <div class ="col-md-5"
        <?php
        echo "<h2><strong>Title: </strong>$item[name]</h2>";
        echo "<h2><strong>Price: $</strong>$item[price]</h2>";
        echo "<h2><strong>Catageory: </strong>$item[category_id]</h2>";
        ?>

             <div class = "col-md-3"></div>
        </div>

        <div class = "row">
            <div class = "col-md-6">
                <?php
                echo "<h2><strong>Message: </strong>$messages[message]</h2>";
                ?>
            </div>
            <div class ="col md-6">
            </div>
        </div>
        <div class = "row">
            <div class = "col-md-5"> </div>
            <div class = "col-md-2"> 
                <a href="<?= site_url(); ?>" class="btn btn-success btn-block" role="button">Reply</a>
            </div>
            <div class = "col-md-5"> </div>
        </div>
    </div>