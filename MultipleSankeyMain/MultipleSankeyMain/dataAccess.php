<?php
/**
 * Created by IntelliJ IDEA.
 * User: Julian
 * Date: 23.07.2015
 * Time: 00:29
 */

$db_link = mysqli_connect("sql4.freesqldatabase.com", "sql483664", "rW8*aG4!","sql483664" );
$sql = "SELECT resdecl_materiallist FROM products_info WHERE p_id = 'Samsung SU57'";
$db_result = mysqli_query($db_link, $sql);
if(! $db_result)
{
    die('Invalid request: ' . mysqli_error());
}
$to_endcode = array();

while($row = mysqli_fetch_assoc($db_result))
{
    $to_endcode = $row;
   }
$to_explode = "";
$to_string = implode($to_explode, $to_endcode);
$to_devide = explode(",", $to_string);


echo json_encode($to_devide);
?>