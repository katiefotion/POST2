<?php
$item = array('name' => 'TESTNAME', 'description' => 'Descritipiont asdfsadf', 'category_id' => 'Tech', 'price' => '4.99');
$message = array('sender_name' => 'John', 'receiver_name' => 'Jason', 'date_sent' => '2017-04-17 22:58:33', 'message' => "hello blah balh bah", 'location_id' => "Quad");
?>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-2">
            <img src="<?= site_url('thumbnail/32'); ?>" class="img-responsive">
            <?php
            echo "";
            $path = site_url("thumbnail/32");
            ?>
        </div>
        <div class="col-md-8">
            <?php
            echo "<h4><strong>Item: </strong>$item[name]</h4>";
            echo "<h4><strong>Price: $</strong>$item[price]</h4>";
            echo "<h4><strong>Catageory: </strong>$item[category_id]</h4>";
            ?>
        </div>
    </div>
    <div class = "row">
        <div class ="col-md-2"></div>
        <div class ="col-md-8">
            <div class="center-block">
                <?php
                echo "<h3>From: $message[sender_name] @ $message[date_sent]</h3>";
                echo "<pre>$message[message]</pre>";
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