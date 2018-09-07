package ThMod_FnH.cards.Marisa;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import ThMod_FnH.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;

public class SuperPerseids extends CustomCard {

  public static final String ID = "SuperPerseids";
  public static final String IMG_PATH = "img/cards/SuperPerseids.png";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = -2;
  private static final int DMG = 18;
  private static final int UPG_DMG = 6;
  private static final int BLC = 5;
  private static final int UPG_BLC = 3;

  public SuperPerseids() {
    super(
        ID,
        NAME,
        IMG_PATH,
        COST,
        DESCRIPTION,
        AbstractCard.CardType.SKILL,
        AbstractCardEnum.MARISA_COLOR,
        AbstractCard.CardRarity.UNCOMMON,
        AbstractCard.CardTarget.SELF
    );

    this.baseDamage = DMG;
    this.block = this.baseBlock = BLC;
    this.damageType = DamageType.THORNS;
    this.damageTypeForTurn = DamageType.THORNS;
  }

  @Override
  public void applyPowers() {
    super.applyPowers();
  }

  public void triggerWhenDrawn() {
    AbstractDungeon.actionManager.addToBottom(
        new GainBlockAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            this.block
        )
    );
  }

  @Override
  public boolean canUse(AbstractPlayer p, AbstractMonster m) {
    return false;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
  }

  public void triggerOnExhaust() {
    AbstractDungeon.actionManager.addToBottom(
        new DamageRandomEnemyAction(
            new DamageInfo(
                AbstractDungeon.player,
                this.damage,
                DamageType.THORNS
            ),
            AttackEffect.FIRE
        )
    );
  }

  public AbstractCard makeCopy() {
    return new SuperPerseids();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(UPG_DMG);
      upgradeBlock(UPG_BLC);
    }
  }
}