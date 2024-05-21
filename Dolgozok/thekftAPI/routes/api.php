<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PositionController;
use App\Http\Controllers\EmployeeController;
use App\Http\Controllers\SelectionController;
use App\Http\Controllers\ProductController;
use App\Http\Controllers\CustomerController;
use App\Http\Controllers\SaleController;
use App\Http\Controllers\InvoiceController;


Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('/positions', [PositionController::class, "getPositions"]);
Route::get('/position/{id}', [PositionController::class, "getOnePosition"]);

Route::get('/employees', [EmployeeController::class, "getEmployees"]);
Route::get('/employee/{id}', [EmployeeController::class, "getOneEmployee"]);
Route::post('/addemployee', [EmployeeController::class, "addEmployee"]);
Route::post('/updateemployee', [EmployeeController::class, "updateEmployee"]);
Route::delete('/deleteemployee', [EmployeeController::class, "deleteEmployee"]);

Route::get('/selections', [SelectionController::class, "getSelections"]);
Route::get('/selection/{id}', [SelectionController::class, "getOneSelection"]);

Route::get('/products', [ProductController::class, "getProducts"]);
Route::get('/product/{id}', [ProductController::class, "getOneProduct"]);
Route::post('/addproduct', [ProductController::class, "addProduct"]);
Route::post('/updateproduct', [ProductController::class, "updateProduct"]);
Route::delete('/deleteproduct', [ProductController::class, "deleteProduct"]);

Route::get('/customers', [CustomerController::class, "getCustomers"]);
Route::get('/customer/{id}', [CustomerController::class, "getOneCustomer"]);
Route::post('/addcustomer', [CustomerController::class, "addCustomer"]);
Route::post('/updatecustomer', [CustomerController::class, "updateCustomer"]);
Route::delete('/deletecustomer', [CustomerController::class, "deleteCustomer"]);

Route::get('/sales', [SaleController::class, "getSales"]);
Route::post('/addsale', [SaleController::class, "addSale"]);

