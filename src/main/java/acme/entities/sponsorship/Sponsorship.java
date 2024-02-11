
package acme.entities.sponsorship;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.client.data.datatypes.Money;

@Entity
@Table(indexes = {
	@Index(columnList = "id")
})
public class Sponsorship extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{1,3}[0-9]{3}$")
	protected String			code;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Valid
	protected Date				moment;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				startPeriod;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				endPeriod;

	@Valid
	@NotNull
	protected Money				price;

	@NotNull
	protected SponsorshipType	type;

	@Email
	protected String			email;

	@URL
	protected String			link;

	protected boolean			draftMode;

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	protected Sponsor			sponsor;

	@Valid
	@NotNull
	@ManyToOne(optional = true)
	protected Project			project;

}
