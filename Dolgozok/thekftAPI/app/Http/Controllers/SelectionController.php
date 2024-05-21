<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Selection;

class SelectionController extends Controller
{
    public function getSelections(){
        $selections = Selection::all();
        return response()->json([
            "data" => $selections
        ]);
    }
    public function getOneSelection($id){
        $selection = Selection::find($id);

        return response()->json([
            "data" => $selection
        ]);
    }
    public function getSelectionId($name){
        $selection = Selection::where('selection_name', $name)->first();
        $id = $selection->id;
        return $id;
    }
}
