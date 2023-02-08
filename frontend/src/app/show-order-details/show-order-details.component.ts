import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../_model/order-details.model';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-show-order-details',
  templateUrl: './show-order-details.component.html',
  styleUrls: ['./show-order-details.component.css']
})
export class ShowOrderDetailsComponent implements OnInit {

  displayedColumns = ['orderId', 'productName', 'orderFullName', 'orderFullOrder', 'orderContactNumber', 'orderAmount', 'orderStatus'];
  OrderDetails: OrderDetails[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAllOrderDetails();
  }

  getAllOrderDetails() {
    this.productService.getAllOrderDetails().subscribe(
      (response: OrderDetails[]) => {
        console.log(response);
        this.OrderDetails = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
