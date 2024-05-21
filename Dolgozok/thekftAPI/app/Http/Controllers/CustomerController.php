<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Customer;

class CustomerController extends Controller
{
    public function getCustomers(){
        $customers = Customer::all();

        return response()->json([
            "data"=>$customers
        ]);
    }
    public function getOneCustomer($id){
        $customer = Customer::find($id);

        return response()->json([
            "data"=>$customer
        ]);
    }
    public function getCustomerId($name){
        $customer = Customer::where('customer_name', $name)->first();
        $id = $customer->id;
        return $id;
    }
    public function addCustomer(Request $request){
        $input = $request->all();

        $customer = new Customer;

        $customer->customer_name = $input["customer_name"];
        $customer->phone_number = $input["phone_number"];

        $customer->save();
        return response()->json([
            "message" => "Sikeres felvétel!",
            "success" => true
        ]);
    }
    public function updateCustomer(Request $request){
        $input = $request->all();
        $id = $input["id"];

        $customer = Customer::find($id);

        $customer->customer_name = $input["customer_name"];
        $customer->phone_number = $input["phone_number"];

        $customer->save();
        return response()->json([
            "message" => "Sikeres felvétel!",
            "success" => true
        ]);
    }
    public function deleteCustomer(Request $request){
        $id = $request->input("id");
        $customer = Customer::find($id);

        $customer->delete();

        return response()->json([
            "message" => "Ügyfél törölve",
            "success" => true
        ]);
      
    }
}