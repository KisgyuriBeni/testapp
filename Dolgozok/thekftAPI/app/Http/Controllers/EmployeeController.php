<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Employee;
use App\Models\Position;

class EmployeeController extends Controller
{
    public function getEmployees(){
        $employees = Employee::with("positions")->get();

        return response()->json([
            "data" => $employees
        ]);
    }
    public function getOneEmployee($id){
        $employee = Employee::with("positions")->find($id);

        return response()->json([
            "data" => $employee
        ]);
    }

    public function getEmployeeId($name){
        $employee = Employee::where('employee_name', $name)->first();
        $id = $employee ? $employee->id : null;
        return $id;
    }

    public function addEmployee(Request $request){
        $input = $request->all();
        $employee = new Employee;
        
        $employee->employee_name = $input["employee_name"];
        $employee->phone_number = $input["phone_number"];
        $employee->hire_date = $input["hire_date"];
        $employee->salary = $input["salary"];
        $employee->position_id = (new PositionController)->getPositionId($input["position_name"]);
    
        $employee->save();
    
        return response()->json([
            "message" => "Sikeres felvétel!",
            "success" => true,
            "data" => $employee
        ]);
    }
    public function updateEmployee(Request $request){
        $input = $request->all();
        $id = $input["id"];
        
        $employee = Employee::find($id);

        $employee->employee_name = $input["employee_name"];
        $employee->phone_number = $input["phone_number"];
        $employee->hire_date = $input["hire_date"];
        $employee->salary = $input["salary"];
        $employee->position_id = (new PositionController)->getPositionId($input["position_name"]);

        $employee->save();
        return response()->json([
            "messages" => "Dolgozó adai sikeresen frissültek!",
            "success" => true,
            "data" => $employee
        ]);
        
    }
    public function deleteEmployee(Request $request){
       $id = $request->input("id");
       $employee = Employee::find($id);
       $employee->delete();
       return response()->json([
        "message" => "Dolgozó törölve!",
        "success" => true
    ]);
    }
    
}
