import {Component, OnInit} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {Contract} from "../model/contract";
import {ExpectedContractService} from "../service/expected-contract.service";

Chart.register(...registerables);

function get_day_of_time(endDate: string, startDate: string) {
  let endDateHd = new Date(endDate);
  let startDateHd = new Date(startDate);
  let ms1 = endDateHd.getTime();
  let ms2 = startDateHd.getTime();
  return Math.ceil((ms1 - ms2) / (24 * 60 * 60 * 1000));
}

@Component({
  selector: 'app-expected-contract',
  templateUrl: './expected-contract.component.html',
  styleUrls: ['./expected-contract.component.css']
})
export class ExpectedContractComponent implements OnInit {

  expectedContractList: Contract[] = [];
  startReturnDate = "";
  endReturnDate = "";
  page = 0;
  totalPage = 0;
  labelList = [];
  profitData = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  contract?: Contract;
  totalProfit = 0;
  myChart: Chart;
  validateEndDate: number;

  constructor(private expectedContractService: ExpectedContractService) {
  }

  ngOnInit(): void {
    this.getAllExpectedContract();
  }

  private getAllExpectedContract() {
    this.expectedContractService.findExpectedContractByDate(this.startReturnDate, this.endReturnDate, this.page).subscribe(contracts => {
      if (contracts === null){
        return this.expectedContractList = [];
      }
      this.expectedContractList = contracts.content;
      this.totalPage = contracts.totalPages;
      console.log(this.expectedContractList);
      for (let i of this.expectedContractList) {
        let day = get_day_of_time(i.endDate, i.startDate);
        console.log(day);
        i.profit = day * (i.itemPrice * (i.interestRate) / 100);
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
      for (let n = 0; n < this.expectedContractList.length; n++) {
        for (let m = 0; m < this.labelList.length; m++) {
          if (this.expectedContractList[n].startDate.slice(5, 7) == this.labelList[m]) {
            this.profitData[m] += this.expectedContractList[n].profit;
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
    this.expectedContractService.findExpectedContractByDate(this.startReturnDate, this.endReturnDate, this.page).subscribe(contracts => {
      if (contracts === null){
        return this.expectedContractList = [];
      }
      this.expectedContractList = contracts.content;
      this.totalPage = contracts.totalPages;
      console.log("search:" + this.expectedContractList);
      for (let i of this.expectedContractList) {
        const day = get_day_of_time(i.endDate, i.startDate);
        console.log(day);
        i.profit = day * (i.itemPrice * (i.interestRate) / 100);
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
      for (let n = 0; n < this.expectedContractList.length; n++) {
        for (let m = 0; m < this.labelList.length; m++) {
          if (this.expectedContractList[n].startDate.slice(5, 7) == this.labelList[m]) {
            this.profitData[m] += this.expectedContractList[n].profit;
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
    this.expectedContractService.findExpectedContractByDate(this.startReturnDate, this.endReturnDate, this.page).subscribe(contracts => {
      this.expectedContractList = contracts.content;
      for (let i of this.expectedContractList) {
        let day = get_day_of_time(i.endDate, i.startDate);
        console.log(day);
        i.profit = day * (i.itemPrice * (i.interestRate) / 100);
        this.totalProfit += i.profit;
      }
    });
  }

  detailContract(id: number) {
    this.expectedContractService.findContractById(id).subscribe(contract => {
      this.contract = contract;
      console.log(contract)
    })
  }

  validateEnd() {
    this.validateEndDate = 0;
    if (get_day_of_time(this.endReturnDate, this.startReturnDate) < 0) {
      this.validateEndDate = 1;
    }
    console.log(get_day_of_time(this.endReturnDate, this.startReturnDate));
  }
}
