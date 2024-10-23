<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <style>
        body {
            background-color: #f3f4f6;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #d1d5db;
            border-radius: 8px;
        }
        .input-field {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            margin-bottom: 16px;
            border: 1px solid #d1d5db;
            border-radius: 4px;
        }
        .radio-container {
            margin-bottom: 20px;
        }
        .radio-label {
            margin-right: 20px;
        }
        .button {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .save-button {
            background-color: #4f46e5;
            color: white;
        }
        .cancel-button {
            background-color: #e5e7eb;
            color: #1f2937;
            margin-left: 8px;
        }
    </style>
        <form class="w-1/2 col-span-3" action="${ pageContext.request.contextPath }/cart?action=pay" method="POST">
            <h2 class="text-lg font-semibold mb-4 ">Checkout - Already registered?</h2>

            <label for="fullname">Fullname:</label>
            <input type="text" name="name" class="input-field" required>

            <label for="address">Shipping address:</label>
            <input type="text" name="address" class="input-field" required>

            <label for="total">Total price:</label>
            <input type="text" name="price" class="input-field" value="${cart.total}" readonly>

            <div class="radio-container">
                <label class="radio-label"><input type="radio" name="payment" value="paypal" checked> Paypal</label>
                <label class="radio-label"><input type="radio" name="payment" value="atm"> ATM Debit</label>
                <label class="radio-label"><input type="radio" name="payment" value="visa"> Visa/Master card</label>
            </div>

            <button type="submit" class="button save-button">Save</button>
            <button type="button" class="button cancel-button">Cancel</button>
        </form>