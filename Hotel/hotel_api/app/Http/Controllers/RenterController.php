<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Renter;
use App\Models\Renting;

class RenterController extends Controller
{
    public function getRenters(){
        $renters = Renter::with("rentings")->get();
        return response()->json([
            "data" => $renters
        ]);
    }
    public function getOneRenter($id){
        $renter = Renter::with("rentings")->find($id);
        return response()->json([
            "data"=>$renter
        ]);
    }
    public function getRenterId($name){
        $renter = Renter::where('name', $name)->first();
        $id = $renter ? $renter->id : null;
        return $id;
    }
}
