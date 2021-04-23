import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common'

class Task {

  id: number;
  title: string;
  description: string;
  status: Status;
  creationDate: string;
  completionDate: string;
  priority: Priority;

  constructor (id?: number, title?: string, description?: string, status?: Status, creationDate?: string, completionDate?: string, priority?: Priority) {
    this.id = id === undefined ? null : id;
    this.title = title === undefined ? '' : title;
    this.description = description === undefined ? '' : description;
    this.status = status === undefined ? 0 : status;
    this.creationDate = creationDate === undefined ? new Date().toString() : creationDate;
    this.completionDate = completionDate === undefined ? new Date().toString() : completionDate;
    this.priority = priority === undefined ? 0 : priority;
  }
  
}

enum Status {
  NEW,
  INPROGRESS,
  COMPLETED
}

enum Priority {
  HIGH,
  MEDIUM,
  LOW
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    tasks: Task[] = [];
    addTaskDiv: boolean = false;
    task: Task = new Task();

    constructor(private datepipe: DatePipe) {

    }

    ngOnInit () {
      const todaysDate = this.datepipe.transform(new Date(), 'dd/MM/yyyy');
      const nextMonthDate = this.datepipe.transform(new Date(new Date().getFullYear(), new Date().getMonth() + 1, new Date().getDate() + 30), 'dd/MM/yyyy');
      this.tasks.push(new Task(1, 'First', 'First task', Status.NEW, todaysDate, nextMonthDate, Priority.LOW));
      this.tasks.push(new Task(2, 'Second', 'Second task', Status.INPROGRESS, todaysDate, nextMonthDate, Priority.MEDIUM));
      this.tasks.push(new Task(3, 'Third', 'Third task', Status.COMPLETED, todaysDate, nextMonthDate, Priority.HIGH));
    }

    addTaskForm (showDiv?: boolean) {
      this.task = new Task();
      this.addTaskDiv = !this.addTaskDiv;
    }

    addTask (task) {
      task.status = Number.parseInt (task.status);
      task.creationDate = this.datepipe.transform(new Date(), 'dd/MM/yyyy');
      if (task.id === null) {
        task.id = this.getIdForNewTask ();
        this.tasks.push(task);
      } else {
        this.tasks.forEach(mytasks => {
          if (mytasks.id === task.id) {
            mytasks = task;
          }
        });
      }
      this.addTaskForm ();
    }

    getStatus (statusString) {
      return Status[statusString];
    }

    getPriority (priorityString) {
      return Priority[priorityString];
    }

    getIdForNewTask () : number {
      return (this.tasks[this.tasks.length - 1].id + 1);
    }

    edit (id: number) {
      if (this.addTaskDiv === true) {
        this.tasks.forEach(task => {
          if (task.id === id) {
            this.task = task;
          }
        });
      } else {
        this.addTaskForm (true);
        this.tasks.forEach(task => {
          if (task.id === id) {
            this.task = task;
          }
        });
      }
    }

    delete (id: number) {
      this.tasks = this.tasks.filter(tasks => tasks.id === id ? false : true);
    }
  
}
