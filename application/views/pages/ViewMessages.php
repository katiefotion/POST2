<h1>Messages</h1>
<p>Sort By:</p>
<button>Date</button>
<button>Item</button>
<button>Messenger</button>
<table>
    <thead>
        <th>Date</th>
        <th>Message</th>
        <th>Item</th>
        <th>Messenger</th>
    </thead>
    <tbody>
            <?php 
                $sql = "SELECT * FROM Messages";
                $qry = mysql_query($sql);

                while($row = mysql_fetch_array($qry)){
                    echo "<tr>
                            <td><input type='checkbox' name='row_id[]' id='rowid_<?php echo $id ?>' value='<?php echo $id ?>' />
                            <td>$row[date]</td>
                            <td>$row[message]</td>
                            <td>$row[item]</td>
                            <td>$row[messenger]</td>
                        </tr>";
                }
            ?>
    </tbody>
</table>
