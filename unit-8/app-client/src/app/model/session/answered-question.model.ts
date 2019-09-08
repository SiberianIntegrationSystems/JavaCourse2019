import {SessionQuestionAnswer} from "./session-question-answer.model";

export interface AnsweredQuestion  {
  id: string;
  answerList: SessionQuestionAnswer[];
}
