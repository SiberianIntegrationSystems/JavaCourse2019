import {JournalItem} from 'src/app/model/core/journal-item.model';
import {QuestionJournalItemAnswer} from './question-journal-item-answer.model';

export interface QuestionJournalItem extends JournalItem {
  answersCount: number;
  answers: QuestionJournalItemAnswer[];
}
