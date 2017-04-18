<?php
$item = array('name' => 'TESTNAME', 'description' => 'Descritipiont asdfsadf', 'category_id' => 'Tech', 'price' => '4.99');
$messages = array('sender_id' => 'John', 'receiver_id' => 'TO ME', 'date_sent' => '4/12/17 5:00', 'message' => "hello blah balh bah", 'location_id' => "Quad");
?>
<div class = "container-fluid">
    <div class = "row">
        <div class = "col-md-1">
        </div>
        <div class = "col-md-3">
            <label for="picture">Picture:</label>
        </div>
        <div class ="col-md-8">
            <?php
            echo "<h3><strong>Title: </strong>$item[name]</h3>";
            echo "<h3><strong>Price: $</strong>$item[price]</h3>";
            echo "<h3><strong>Catageory: </strong>$item[category_id]</h3>";
            ?>
        </div>

        <div class = "row">
            <div class ="col-md-2"></div>
            <div class ="col-md-8">
                <div class="center-block">
                    <?php
                    echo "<h3>From: $messages[sender_id]</h3>";
                    echo "<pre>$messages[message]</pre>";
                    ?>
                </div>
                
                <form>
                    <div class="form-group">
                        <label for="reply">Reply:</label>
                        <textarea class="form-control" rows="5" id="description" name = "reply"></textarea>
                    </div>
                </form>
                
            </div>
            <div class ="col-md-2"></div>

        </div>

        <div class = "row">
            <div class = "col-md-5"> </div>
            <div class = "col-md-2"> 
                <a href="<?= site_url("ViewMessages"); ?>" class="btn btn-default btn-block" role="button">Back</a>

                <a href="<?= site_url(); ?>" button type="submit" class="btn btn-success btn-block"  role="button">Reply</a>
            </div>
            <div class = "col-md-5"> </div>
        </div>
    </div>