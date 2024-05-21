<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Sale;

class SaleController extends Controller
{
    public function getSales(){
        $sales = Sale::with("employees", "products", "customers")->get();

        return response()->json([
            "data" => $sales
        ]);
    }
    public function addSale(Request $request){
        $input = $request->all();
        $sale = new Sale;

        $sale->sale_date = $input["sale_date"];
        $sale->paid = $input["paid"];
        $sale->employee_id = (new EmployeeController)->getEmployeeId($input["employee_name"]);
        $sale->product_id = (new ProductController)->getProductId($input["product_name"]);
        $sale->customer_id = (new CustomerController)->getCustomerId($input["customer_name"]);

        $sale->save();

        return response()->json([
            "message" => "Sikeresen rögzített eladás!",
            "success" => true,
            "data" => $sale
        ]);
    }
}
