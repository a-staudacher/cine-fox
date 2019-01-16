export interface Person {
  id?: number;
  vorname: string;
  nachname: string;
  movies?: Array<any>;
  dayOfBirth?: Date;
}
