<html>

<head>
  <title>UNIT 2 - E10</title>
</head>

<body>
  <?php



  function string_file_extension(string $filename)
  {
    //$extension = trim($filename);
    $extension = explode(".", $filename);

    $extension = strtoupper($extension[1]);

    return $extension;
  }

  function string_file_type(string $extension)
  {

    $tipoArchivo = [
      "PDF"  => "Adobe File",
      "TXT"  => "Text File",
      "HTML" => "HTML File",
      "HTM"  => "HTML File",
      "PPT"  => "Microsoft Powerpoint File",
      "DOC"  => "Microsoft Word File",
      "GIF"  => "GIF Image",
      "JPG"  => "JPG Image",
      "ZIP"  => "ZIP File"
    ];

    $extension = strtoupper($extension);

    foreach ($tipoArchivo as $type) {
      if ($extension == $type) {
        $type = $tipoArchivo[$extension];
      } else {
        $type = $extension . " File";
      }
    }

    return $type;
  }

  ?>


</body>

</html>