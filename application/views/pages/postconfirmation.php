
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

<body>
    <div class="center">
        <h1>Thank you for posting!</h1> 
    </div>
    
    <h2>Review</h2>

    <div class = "container">
        <div class = "row">
            <div class = "col-md-3">
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
    </div>

    <p>Review email shortly...</p>
    <button type="button" class="btn btn-default btn-block">Click here to edit</button>
</body>

