<?php include 'wizard.php'; ?>
<h1>Step 2: Living Area</h1>
<p>Step 2 of 4</p>
<form action="wizard.php?step=3" method="get">
  <label for="zone">Zone:</label>
  <select name="zone" id="zone" required>
    <option value="Center" <?= (isset($_SESSION['zone']) && $_SESSION['zone'] == 'Center') ? 'selected' : '' ?>>Center</option>
    <option value="Richiland" <?= (isset($_SESSION['zone']) && $_SESSION['zone'] == 'Richiland') ? 'selected' : '' ?>>Richiland</option>
    <option value="Mid-City" <?= (isset($_SESSION['zone']) && $_SESSION['zone'] == 'Mid-City') ? 'selected' : '' ?>>Mid-City</option>
  </select>
  <input type="button" value="< Previous" onclick="loadPage('wizard.php?step=1')">
  <button type="submit">Next ></button>
</form>
<script>
  function loadPage(page) {
    window.location = page;
  }
</script>