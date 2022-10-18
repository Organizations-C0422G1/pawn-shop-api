import {Component, OnInit} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {Contract} from "../model/contract";
import {LiquidationContractService} from "../service/liquidation-contract.service";

Chart.register(...registerables);

@Component({
  selector: 'app-liquidation-contract',
  templateUrl: './liquidation-contract.component.html',
  styleUrls: ['./liquidation-contract.component.css']
})
export class LiquidationContractComponent implements OnInit {
  liquidationContractList: Contract[] = [];
  startReturnDate = "";
  endReturnDate = "";
  page = 0;
  totalPage: number;
  labelList = [];
  profitData = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  contract?: Contract;
  totalProfit = 0;
  myChart: Chart;

  constructor(private liquidationContractService: LiquidationContractService) {
  }

  ngOnInit(): void {
    this.getAllLiquidationContract();
  }

  private getAllLiquidationContract() {
    this.liquidationContractService.findCompleteContractByDate(this.startReturnDate, this.endReturnDate, this.page).subscribe(contracts => {
      this.liquidationContractList = contracts.content;
      this.totalPage = contracts.totalPages;
      for (let i of this.liquidationContractList) {
        i.profit = i.liquidationPrice - i.itemPrice
        this.totalProfit += i.profit;
        let a = i.startDate.slice(5, 7);
        console.log(a);
        if (this.labelList.length === 0) {
          this.labelList.push(a);
        } else {
          for (let k of this.labelList) {
            if (this.labelList.indexOf(a) === -1) {
              this.labelList.push(a);
            }
          }
        }
        console.log(this.labelList);
      }
      this.labelList.sort();
      console.log(this.labelList);
      for (let n = 0; n < this.liquidationContractList.length; n++) {
        for (let m = 0; m < this.labelList.length; m++) {
          if (this.liquidationContractList[n].startDate.slice(5, 7) == this.labelList[m]) {
            this.profitData[m] += this.liquidationContractList[n].profit;
            console.log(this.profitData[m]);
          }
        }
      }
      console.log("data" + this.profitData);
    });
  }

  search() {
    this.page = 0;
    this.totalProfit = 0;
    this.labelList = [];
    this.profitData = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    this.liquidationContractService.findCompleteContractByDate(this.startReturnDate, this.endReturnDate, this.page).subscribe(contracts => {
      this.liquidationContractList = contracts.content;
      this.totalPage = contracts.totalPages;
      console.log("search:" + this.liquidationContractList);
      for (let i of this.liquidationContractList) {
        i.profit = i.liquidationPrice - i.itemPrice
        this.totalProfit += i.profit;
        let a = i.startDate.slice(5, 7);
        if (this.labelList.length === 0) {
          this.labelList.push(a);
        } else {
          for (let k of this.labelList) {
            if (this.labelList.indexOf(a) === -1) {
              this.labelList.push(a);
            }
          }
        }
      }
      this.labelList.sort();
      for (let n = 0; n < this.liquidationContractList.length; n++) {
        for (let m = 0; m < this.labelList.length; m++) {
          if (this.liquidationContractList[n].startDate.slice(5, 7) == this.labelList[m]) {
            this.profitData[m] += this.liquidationContractList[n].profit;
            console.log(this.profitData[m]);
          }
        }
      }
      console.log("data" + this.profitData);
    });
  }

  click() {
    if (this.myChart != null) this.myChart.destroy();
    let labelString = [];
    for (let i of this.labelList) {
      if (i == "01") {
        labelString.push("January");
        continue;
      }
      if (i == "02") {
        labelString.push("February");
        continue;
      }
      if (i == "03") {
        labelString.push("March");
        continue;
      }
      if (i == "04") {
        labelString.push("April");
        continue;
      }
      if (i == "05") {
        labelString.push("May");
        continue;
      }
      if (i == "06") {
        labelString.push("June");
        continue;
      }
      if (i == "07") {
        labelString.push("July");
        continue;
      }
      if (i == "08") {
        labelString.push("August");
        continue;
      }
      if (i == "09") {
        labelString.push("September");
        continue;
      }
      if (i == "10") {
        labelString.push("October");
        continue;
      }
      if (i == "11") {
        labelString.push("November");
        continue;
      }
      if (i == "12") {
        labelString.push("December");
      }
    }
    this.myChart = new Chart("myChart", {
      type: 'line',
      data: {
        labels: labelString,
        datasets: [{
          label: 'Lợi nhuận theo tháng',
          data: this.profitData,
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
        }]
      },
      options: {
        animations: {
          tension: {
            duration: 1000,
            easing: 'linear',
            from: 1,
            to: 0,
            loop: true
          }
        },
        scales: {
          y: {
            title: {
              display: true,
              text: '$ Tiền lãi $'
            }
          },
          x: {
            title: {
              display: true,
              text: '$ Month $'
            }
          }
        }

      }
    });
  }

  detailContract(id: number) {
    this.liquidationContractService.findContractById(id).subscribe(contract => {
      this.contract = contract;
      console.log(contract)
    })
  }

  getPage(currentPage: number) {
    this.totalProfit = 0;
    this.page = currentPage;
    if (this.page < 0) {
      this.page = 0;
    } else {
      if (this.page > this.totalPage) {
        this.page = this.totalPage - 1;
      }
    }
    this.liquidationContractService.findCompleteContractByDate(this.startReturnDate, this.endReturnDate, this.page).subscribe(contracts => {
      this.liquidationContractService = contracts.content;
      for (let i of this.liquidationContractList) {
        i.profit = i.liquidationPrice - i.itemPrice
        this.totalProfit += i.profit;
      }
    });
  }
}
