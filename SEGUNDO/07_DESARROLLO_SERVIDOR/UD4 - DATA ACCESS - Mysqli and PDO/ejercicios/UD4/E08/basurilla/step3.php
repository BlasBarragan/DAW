<?php include 'wizard.php'; ?>
<h1>Step 3: Number of Bedrooms and Price</h1>
<p>Step 3 of 4</p>
<form action="wizard.php?step=4" method="get">
  <label for="nrooms">Number of Rooms:</label>
  <select name="nrooms" id="nrooms" required>
    <option value="1" <?= (isset($_SESSION['nrooms']) && $_SESSION['nrooms'] == '1') ? 'selected' : '' ?>>1</option>
    <option value="2" <?= (isset($_SESSION['nrooms']) && $_SESSION['nrooms'] == '2') ? 'selected' : '' ?>>2</option>
    <option value="3" <?= (isset($_SESSION['nrooms']) && $_SESSION['nrooms'] == '3') ? 'selected' : '' ?>>3</option>
    <option value="4" <?= (isset($_SESSION['nrooms']) && $_SESSION['nrooms'] == '4') ? 'selected' : '' ?>>4</option>
    <option value="5" <?= (isset($_SESSION['nrooms']) && $_SESSION['nrooms'] == '5') ? 'selected' : '' ?>>5</option>
  </select>
  <br>
  <label for="price_min">Price Range:</label>
  <input type="number" name="price_min" placeholder="Min Price" value="<?= isset($_SESSION['price_min']) ? $_SESSION['price_min'] : '' ?>" required>
  <input type="number" name="price_max" placeholder="Max Price" value="<?= isset($_SESSION['price_max']) ? $_SESSION['price_max'] : '' ?>" required>
  <input type="button" value="< Previous" onclick="loadPage('wizard.php?step=2')">
  <button type="submit">Next ></button>
</form>
<script>
  function loadPage(page) {
    window.location = page;
  }
</script>