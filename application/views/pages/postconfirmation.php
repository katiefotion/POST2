
<head>
    <style>
        .center {
            text-align: center;
        }
        .right {
            text-align: right;
        }

    </style>
</head>

<div class="containter-fluid">
    <div class="center">
        <h1>Thank you for posting!</h1> 
    </div>

    <h2>Review</h2>

    <div class = "row">
        <div class = "col-md-3 min-lr-pad">
            <?php
            $path = site_url("dbimg/$item->photo");
            echo "<img src='$path' class='img-responsive'>";
            ?>
        </div>
        <div class = "col-md-7">
            <?php
            echo "<h2><strong>Item name: </strong>$item->name</h2>";
            echo "<h3><strong>Description </strong></h3><br>";
            echo "<p>$item->description</p>";
            ?>
        </div>
        <div class = "col-md-2">
            <h3>Price: $<?= number_format($item->price, 2); ?></h3>
        </div>
    </div>

    <div class="right">
        <button type="button" class="btn btn-outline-primary">Click here to edit</button>
    </div>
</div>


