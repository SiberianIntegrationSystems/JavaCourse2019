import {AnsweredQuestion} from "./answered-question.model";

export interface NewSession  {
  id?: string;
  name: string;
  questionList: AnsweredQuestion[];
}
