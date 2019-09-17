# AnnuityPlanGenerator
In order to inform borrowers about the final repayment schedule, we need to have pre-calculated repayment plans throughout the lifetime of a loan. To be able to calculate a repayment plan specific input parameters are necessary: • duration (number of instalments in months) • nominal interest rate • total loan amount ("total principal amount") • Date of Disbursement/Payout These four parameters need to be input parameters. The goal is to calculate a repayment plan for an annuity loan. Therefore the amount that the borrower has to pay back every month, consisting of principal and interest repayments, does not change (the last instalment might be an exception).
you need to run maven build with goal (clean install)
run the project as spring boot application
you can call the API using any rest client application like postman or insomnia with the below details:
URL: http://localhost:8080
HTTP method: POST
send the request body with the below format
{
"loanAmount": "5000",
"nominalRate": "5.0",
"duration": 24,
"startDate": "2018-01-01T00:00:01Z"
}
