<div class="container-fluid">
    <div class="text-center">
        <h1>Messages</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
              <th></th>
              <th id="date" onclick="formatColumn1()">Date &#x25B2</th>
              <th id="message">Message</th>
              <th id="item" onclick="formatColumn2()">Item &#x25B2</th>
              <th id="messenger" onclick="formatColumn3()">Messenger &#x25B2</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="checkbox" value=""></td>
              <td>3/14/17</td>
              <td>I would like to buy that</td>
              <td>Box of Cigarettes</td>
              <td>Mike Smith</td>
            </tr>
            <tr>
              <td><input type="checkbox" value=""></td>
              <td>3/15/17</td>
              <td>Does it come in blue?</td>
              <td>Bowling Ball</td>
              <td>Sally King</td>
            </tr>
          </tbody>
        </table>
        <button type="button" onclick="">Delete</button>
    </div>
</div>

<script>
    function formatColumn1(){
        if(document.getElementById("date").innerHTML === "Date &#x25BC"){
            document.getElementById("date").innerHTML === "Date &#x25B2"
        }
        else
            document.getElementById("date").innerHTML = "Date &#x25BC"
    }
    function formatColumn2(){
        document.getElementById("item").innerHTML = "Item &#x25BC";
    }
    function formatColumn3(){
        document.getElementById("messenger").innerHTML = "Messenger &#x25BC";
    }
</script>
