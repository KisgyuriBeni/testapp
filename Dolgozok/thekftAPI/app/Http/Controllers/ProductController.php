<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Product;

class ProductController extends Controller
{
    public function getProducts(){

        $products = Product::with("selections")->get();
        return response()->json([
            "data"=>$products
        ]);
    }
    public function getOneProduct($id){
        $product = Product::with("selections")->find($id);
        return response()->json([
            "data" => $product
        ]);
    }
    public function getProductId($name){
        $product = Product::where('product_name', $name)->first();
        $id = $product->id;        
        return $id;
    }
    public function addProduct(Request $request){
        $input = $request->all();
        $product = new Product;

        $product->product_name = $input["product_name"];
        $product->amount = $input["amount"];
        $product->price = $input["price"];
        $product->selection_id = (new SelectionController)->getSelectionId($input["selection_name"]);
        $product->purchaser = $input["purchaser"];

        $product->save();
        return response()->json([
            "success" => true,
            "data" => $product
        ]);
    }
    public function updateProduct(Request $request){
        $input = $request->all();
        $id = $input["id"];

        $product = Product::find($id);

        $product->product_name = $input["product_name"];
        $product->amount = $input["amount"];
        $product->price = $input["price"];
        $product->selection_id = (new SelectionController)->getSelectionId($input["selection_name"]);
        $product->purchaser = $input["purchaser"];

        $product->save();
        return response()->json([
            "success" => true,
            "data" => $product
        ]);
    }
    public function deleteProduct(Request $request){
        $id = $request->input("id");
        $product = Product::find($id);
        $product->delete();
        return response()->json([
            "message" => "Termék törölve!",
            "succes" => true
        ]);
    }
}
