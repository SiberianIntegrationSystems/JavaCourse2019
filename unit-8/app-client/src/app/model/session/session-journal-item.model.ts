import {JournalItem} from 'src/app/model/core/journal-item.model';

export interface SessionJournalItem extends JournalItem {
  result: number;
}
