<?php include 'wizard.php'; ?>
<h1>Step 4: Extra Characteristics</h1>
<p>Step 4 of 4</p>
<form action="results.php" method="get">
  <label for="extras">Extras:</label>
  <input type="checkbox" name="extras[]" value="Swimming pool" <?= (isset($_SESSION['extras']) && in_array('Swimming pool', $_SESSION['extras'])) ? 'checked' : '' ?>> Swimming pool
  <input type="checkbox" name="extras[]" value="Garden" <?= (isset($_SESSION['extras']) && in_array('Garden', $_SESSION['extras'])) ? 'checked' : '' ?>> Garden
  <input type="checkbox" name="extras[]" value="Garage" <?= (isset($_SESSION['extras']) && in_array('Garage', $_SESSION['extras'])) ? 'checked' : '' ?>> Garage
  <input type="button" value="< Previous" onclick="loadPage('wizard.php?step=3')">
  <button type="submit">See Results ></button>
</form>
<script>
  function loadPage(page) {
    window.location = page;
  }
</script>