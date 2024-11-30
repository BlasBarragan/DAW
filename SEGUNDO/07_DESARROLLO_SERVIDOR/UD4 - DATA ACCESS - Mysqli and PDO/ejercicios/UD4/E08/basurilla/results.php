<?php
include 'wizard.php';
include 'db.php';

$type = $_SESSION['type'];
$zone = $_SESSION['zone'];
$nrooms = $_SESSION['nrooms'];
$price_min = $_SESSION['price_min'];
$price_max = $_SESSION['price_max'];
$extras = isset($_SESSION['extras']) ? $_SESSION['extras'] : [];

$query = "SELECT * FROM houses WHERE type = :type AND zone = :zone AND nrooms = :nrooms AND price BETWEEN :price_min AND :price_max";

if (!empty($extras)) {
  $extras_conditions = [];
  foreach ($extras as $key => $extra) {
    $extras_conditions[] = "FIND_IN_SET(:extra_$key, extras)";
  }
  $query .= " AND (" . implode(' OR ', $extras_conditions) . ")";
}

$stmt = $pdo->prepare($query);
$stmt->bindParam(':type', $type);
$stmt->bindParam(':zone', $zone);
$stmt->bindParam(':nrooms', $nrooms);
$stmt->bindParam(':price_min', $price_min);
$stmt->bindParam(':price_max', $price_max);

if (!empty($extras)) {
  foreach ($extras as $key => $extra) {
    $stmt->bindParam(":extra_$key", $extra);
  }
}

$stmt->execute();
$results = $stmt->fetchAll();

if ($results) {
  echo "<h1>Search Results</h1><ul>";
  foreach ($results as $house) {
    echo "<li>{$house['type']} in {$house['zone']} with {$house['nrooms']} rooms, priced at {$house['price']} €.</li>";
  }
  echo "</ul>";
} else {
  echo "<h1>No results found.</h1>";
}
